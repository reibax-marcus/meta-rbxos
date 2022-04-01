SUMMARY = "C++ library for linear algebra & scientific computing"
DESCRIPTION = "Armadillo is a high quality linear algebra library \
(matrix maths) for the C++ language, aiming towards a good balance \
between speed and ease of use"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
SRC_URI = "https://sourceforge.net/projects/arma/files/armadillo-10.8.2.tar.xz;protocol=http"
SRC_URI[sha256sum] = "89fdd898bf6bff75f6efc3a301817e4ede752b9a80927fb07ee358b13e353922"

DEPENDS = "lapack"

# Make sure our source directory (for the build) matches the directory structure in the tarball
S = "${WORKDIR}/${PN}-${PV}"

inherit cmake

FILES:${PN}-dbg += " /usr/share/Armadillo/CMake "
