DESCRIPTION = "GPG keys for local file encryption. rbxos distributable images."
LICENSE = "CLOSED"

inherit native

PV = "1.0.1"

SRC_URI = " \
    file://rbxos.open.gpg.pubk \
    file://rbxos.open.gpg.privk \
    "

GPG_PUBKF = "rbxos.open.gpg.pubk"
GPG_PRIVKF = "rbxos.open.gpg.privk"

DEPENDS = "gnupg-native"

do_build() {
    :
}

do_install() {
     gpg --import ${WORKDIR}/${GPG_PUBKF}
     gpg --import ${WORKDIR}/${GPG_PRIVKF}
}

FILES:${PN} = ""
