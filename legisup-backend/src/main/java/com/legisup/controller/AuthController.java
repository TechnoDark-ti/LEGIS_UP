package com.legisup.controller;

import com.legisup.model.Usuario;
import com.legisup.repository.UsuarioRepository;
import com.legisup.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String login = request.get("login");
        String senha = request.get("senha");

        if (login == null || senha == null) {
            return ResponseEntity.badRequest().body("Login e senha são obrigatórios.");
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.findByLogin(login);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
        }

        Usuario usuario = usuarioOpt.get();
        if (!passwordEncoder.matches(senha, usuario.getSenhaHash())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
        }

        String token = jwtService.gerarToken(usuario.getLogin(), usuario.getPerfil().getNome());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("login", usuario.getLogin());
        response.put("perfil", usuario.getPerfil().getNome());

        return ResponseEntity.ok(response);
    }
}