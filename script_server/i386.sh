
# ShellScript Desenvolvido por GameLinux - @Ales S.
# Adaptado por @Márcio Moda - TechnoDark
# Todos os direitos reservados ao GameLinux - @Alex S.


#!/bin/bash


# Verificação de arquitetura 32 bits
sudo dpkg --add-architecture i386 && echo 'Arquitetura i386 adicionada ao dpkg com sucesso.'
sudo apt update

# Código obsoleto 


# if nvidia-smi &> /dev/null; then
#     GAMELINUX_NVIDIA_DRIVER_VERSION=$(nvidia-smi -q | awk '/Driver Version/{print $NF}' | cut -d "." -f 1 | tr " " "-")
#     sudo apt install -y libnvidia-compute"$GAMELINUX_NVIDIA_DRIVER_VERSION":i386 \
#                         libnvidia-decode"$GAMELINUX_NVIDIA_DRIVER_VERSION":i386 \
#                         libnvidia-encode"$GAMELINUX_NVIDIA_DRIVER_VERSION":i386 \
#                         libnvidia-fbc1"$GAMELINUX_NVIDIA_DRIVER_VERSION":i386 \
#                         libnvidia-gl"$GAMELINUX_NVIDIA_DRIVER_VERSION":i386

#                         ##Drivers destualizados!
# else
#     echo 'Driver Nvidia não está presente ou não está funcionando corretamente.'
# fi

# Instalação de drivers essenciais e utilitários
sudo apt install -y zenity sed x11-utils libvulkan-dev libx11-data libc6:i386 \
                    libsdl2-gfx-1.0-0:i386 libsdl2-image-2.0-0:i386 \
                    libsdl2-ttf-2.0-0:i386 libxcb-xf86dri0:i386 libvulkan1:i386\
                    libxdamage1:i386 libgssapi-krb5-2:i386 libegl1-mesa:i386 \
                    libgles2-mesa:i386 libglu1-mesa:i386 libglapi-mesa:i386 \
                    libgl1:i386 libgl1-mesa-dri:i386 libglx-mesa0:i386 \
                    libwayland-egl1-mesa:i386 mesa-vulkan-drivers:i386 \
                    libxext6:i386 libgl1-mesa-glx:i386 libcanberra-pulse:i386 \
                    libx11-6:i386 libjack-jackd2-0:i386 libvisual-0.4-0:i386 \
                    gstreamer1.0-pulseaudio:i386 libglib2.0-0:i386 libgphoto2-6:i386 \
                    libasound2-plugins:i386 libgstreamer-plugins-base1.0-0:i386 \
                    liblcms2-2:i386 libmpg123-0:i386 libopenal1:i386 libpcap0.8:i386 \
                    libfontconfig1:i386 libosmesa6:i386 libxcomposite1:i386 \
                    libfontconfig1:i386 libasn1-8-heimdal:i386 libavahi-client3:i386 \
                    libavahi-common-data:i386 libexif12:i386 libheimntlm0-heimdal:i386 \
                    libhx509-5-heimdal:i386 libieee1284-3:i386 libk5crypto3:i386 \
                    libkeyutils1:i386 libkrb5-26-heimdal:i386 libkrb5support0:i386 \
                    libsasl2-2:i386 libsasl2-modules:i386 libsasl2-modules-db:i386 \
                    libsqlite3-0:i386 libusb-1.0-0:i386 libv4lconvert0:i386 \
                    libwind0-heimdal:i386 libxpm4:i386 libunwind8:i386 libxml2:i386 \
                    libcapi20-3:i386 libcups2:i386 libodbc1:i386 libsane1:i386 \
                    libv4l-0:i386 libxslt1.1:i386 libxtst6:i386 gstreamer1.0-gl:i386 \
                    libgstreamer-gl1.0-0:i386 gstreamer1.0-plugins-ugly:i386 \
                    mesa-vdpau-drivers:i386 libjpeg62:i386 libva2:i386 libspeex1:i386 \
                    libva-drm2:i386 libpangocairo-1.0-0:i386 \
                    libncurses6:i386 libncursesw6:i386 libncurses5:i386 libncursesw5:i386 \
                    libvkd3d1  libldap-2.5-0:i386 ocl-icd-libopencl1:i386 \
                    libssl3:i386 libwebp7:i386 libfuse2 libfuse3-3 libglu1-mesa:i386

##pacotes desatualizados
#libidn11:i386 libnvidia-compute:i386 libnvidia-decode:i386 \
#               libnvidia-encode:i386 libnvidia-fbc1:i386 libnvidia-gl:i386
###

# Utilitários padrão de Desktop
#sudo apt install -y libreoffice libreoffice-l10n-bn inkscape
# Utilitários de Mídia para desktop + acesso remoto
sudo apt install remmina -y
# Ferramentas e configurações para Linux
sudo apt install -y vim htop net-tools \
                    wine neofetch flatpak git plocate
# Bibliotecas para desenvolvimento Java
sudo apt install -y openjdk-19-jdk
# Ferramentas para conexão de banco de dados
sudo apt install -y mysql-server-core-8.0 mysql-server-8.0 mysql-cliente-core-8.0 mysql-client-8.0
# Docker
sudo apt install -y docker-compose docker.io docker