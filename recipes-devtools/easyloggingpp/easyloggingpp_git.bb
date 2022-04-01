SUMMARY = "Single header C++ logging library"
HOMEPAGE = "https://zuhd.org"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14f94a67255d7d102dc302c4c17b566f"

SRC_URI = "git://github.com/zuhd-org/easyloggingpp.git"

PV = "9.96.7+git${SRCPV}"

SRCREV = "20fdea6e1b5ae42fb50c9179e332c22242030a38"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-Dtest=OFF"

# easyloggingpp is a header only C++ library, so the main package will be empty.

RDEPENDS:${PN}-dev = ""

BBCLASSEXTEND = "native nativesdk"
