DESCRIPTION = "RSA keys for ssh access"
LICENSE = "CLOSED"

inherit allarch

SRC_URI = "\
          file://profile \
          file://bashrc \
          "

do_build() {
    :
}

do_install() {
    install -d ${D}${ROOT_HOME}
    install -m 644 "${WORKDIR}/profile" "${D}${ROOT_HOME}/.profile"
    install -m 644 "${WORKDIR}/bashrc" "${D}${ROOT_HOME}/.bashrc"
}

FILES:${PN} = "${ROOT_HOME}/.profile \
               ${ROOT_HOME}/.bashrc \
               "