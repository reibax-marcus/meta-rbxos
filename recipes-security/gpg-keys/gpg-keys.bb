DESCRIPTION = "GPG keys for local file encryption. rbxos distributable images."
LICENSE = "CLOSED"

inherit allarch

PV = "1.0.2"

SRC_URI = " \
    file://rbxos.open.gpg.pubk \
    file://rbxos.open.gpg.privk \
    file://install-gpg-keys \
    "

GPG_PUBKF = "rbxos.open.gpg.pubk"
GPG_PRIVKF = "rbxos.open.gpg.privk"

RDEPENDS:${PN}-pub = "gnupg"

PACKAGES = "${PN} ${PN}-priv ${PN}-pub"

do_build() {
    :
}

do_install() {
    install -d 0755 ${D}${datadir}/gpg-keys
    install -m 0644 ${WORKDIR}/${GPG_PUBKF} "${D}${datadir}/gpg-keys/"
    install -m 0644 ${WORKDIR}/${GPG_PRIVKF} "${D}${datadir}/gpg-keys/"
    install -d 0755 "${D}${bindir}"
    install -m 0755 ${WORKDIR}/install-gpg-keys "${D}${bindir}" 
    install -d 0755 ${D}/etc/swu-postinst/collection
    ln -sfT "${bindir}/install-gpg-keys" "${D}/etc/swu-postinst/collection/install-gpg-keys"
}

pkg_postinst_ontarget:${PN}-pub() {
${bindir}/install-gpg-keys
}

FILES:${PN} = ""
FILES:${PN}-pub = " \
        ${datadir}/gpg-keys/${GPG_PUBKF} \
        /etc/swu-postinst/collection/install-gpg-keys \
        ${bindir}/install-gpg-keys \
        "
FILES:${PN}-priv = " \
        ${datadir}/gpg-keys/${GPG_PRIVKF} \
        "
