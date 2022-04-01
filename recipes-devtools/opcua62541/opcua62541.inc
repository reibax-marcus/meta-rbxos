SUMMARY = "Open source implementation of OPC UA (OPC Unified Architecture) aka IEC 62541 licensed under Mozilla Public License v2.0"
HOMEPAGE = "https://open62541.org/"
SECTION = "libs"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS += "openssl"
RDEPENDS:${PN} = "libssl"

SRC_URI = " \
    git://git@github.com/open62541/open62541.git;protocol=https;nobranch=1 \
    file://0001-Fix-openssl-dependency-path-use-to-enable-cross-comp.patch \
    "

inherit cmake python3native

EXTRA_OECMAKE += "-DUA_ENABLE_ENCRYPTION=ON -DUA_ENABLE_ENCRYPTION_OPENSSL=ON"

S = "${WORKDIR}/git"

RDEPENDS:${PN}-dev = ""

do_install:append() {
     rm -rf ${D}/usr/share
}

BBCLASSEXTEND = "native nativesdk"
