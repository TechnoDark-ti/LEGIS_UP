package com.legisup.config;

import com.legisup.model.Usuario;
import com.legisup.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<Usuario> adminOpt = usuarioRepository.findByLogin("admin");
        if (adminOpt.isPresent()) {
            Usuario admin = adminOpt.get();
            admin.setSenhaHash(passwordEncoder.encode("admin123"));
            usuarioRepository.save(admin);
            System.out.println(">>> [LEGIS_UP] Palavra-passe do utilizador 'admin' atualizada com sucesso! <<<");
        }
    }
}