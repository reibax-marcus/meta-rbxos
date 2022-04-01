# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Read key-value pairs from a .env file and set them as environment variables"
HOMEPAGE = "https://github.com/theskumar/python-dotenv"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=55ee2c3471d386636a719c8ccac40b31"

SRC_URI = "git://github.com/theskumar/python-dotenv;protocol=https;nobranch=1"

# Modify these as desired
PV = "0.19.2+git${SRCPV}"
SRCREV = "2471a5af1027acca27f8d326ddb97b1d43a2ba23"

S = "${WORKDIR}/git"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "cli"
PACKAGECONFIG[cli] = ",,,python3-click"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-click python3-core python3-io python3-logging python3-shell"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    IPython.core.magic
#    IPython.core.magic_arguments
#    typing
#    python3-contextlib


