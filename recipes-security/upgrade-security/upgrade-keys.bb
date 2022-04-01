DESCRIPTION = "RSA keys for upgrade system"
LICENSE = "CLOSED"

inherit allarch

SRC_URI = " \
    file://aes256_symmetric.crypt \
    file://priv.pem \
    file://public.pem \
    file://.swupdate_priv_pwd \
    file://aes256.key \
    "

PACKAGES = "${PN} ${PN}-priv ${PN}-pub ${PN}-sym"

do_build() {
    :
}

do_install() {
    install -d 0755 ${D}/www/swupdate/keys
    install -m 0644 ${WORKDIR}/public.pem ${D}/www/swupdate/keys/
    install -d 0755 ${D}${datadir}/upgrade-keys
    install -m 0644 ${WORKDIR}/aes256_symmetric.crypt ${D}${datadir}/upgrade-keys/
    install -m 0644 ${WORKDIR}/priv.pem ${D}${datadir}/upgrade-keys/
    install -m 0644 ${WORKDIR}/.swupdate_priv_pwd ${D}${datadir}/upgrade-keys/
    install -m 0400 ${WORKDIR}/aes256.key ${D}${datadir}/upgrade-keys/
}

FILES:${PN} = ""
FILES:${PN}-pub = "/www/swupdate/keys/public.pem"
FILES:${PN}-priv = " \
        ${datadir}/upgrade-keys/aes256_symmetric.crypt \
        ${datadir}/upgrade-keys/priv.pem \
        ${datadir}/upgrade-keys/.swupdate_priv_pwd \
        "
FILES:${PN}-sym = "${datadir}/upgrade-keys/aes256.key"
