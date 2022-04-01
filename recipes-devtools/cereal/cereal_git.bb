SUMMARY = "A C++11 library for serialization"
HOMEPAGE = "http://uscilab.github.com/cereal"
SECTION = "libs"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=e612690af2f575dfd02e2e91443cea23"

SRC_URI = "git://github.com/USCiLab/cereal.git"

PV = "1.2.2+git${SRCPV}"

SRCREV = "51cbda5f30e56c801c07fe3d3aba5d7fb9e6cca4"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DJUST_INSTALL_CEREAL=ON"

# cereal is a header only C++ library, so the main package will be empty.

RDEPENDS:${PN}-dev = ""

BBCLASSEXTEND = "native nativesdk"
