# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Extended JWT integration with Flask"
HOMEPAGE = "https://github.com/vimalloc/flask-jwt-extended"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9166295d7c482b9440bbb2b5c0fa43ac"

SRC_URI = "git://github.com/vimalloc/flask-jwt-extended.git;protocol=https"

# Modify these as desired
PV = "4.3.1+git${SRCPV}"
SRCREV = "2c7ae9e81de030f67fb3577be7a74f2a6b7ef5a2"

S = "${WORKDIR}/git"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "asymmetric_crypto"
PACKAGECONFIG[asymmetric_crypto] = ",,,python3-cryptography"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-flask python3-pyjwt python3-werkzeug"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-datetime python3-flask python3-netclient python3-werkzeug"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    collections.abc
#    jwt
#    jwt.algorithms
#    python3-lang


