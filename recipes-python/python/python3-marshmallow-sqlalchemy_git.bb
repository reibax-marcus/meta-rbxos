# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "SQLAlchemy integration with the marshmallow (de)serialization library"
HOMEPAGE = "https://github.com/marshmallow-code/marshmallow-sqlalchemy"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   docs/license.rst
# NOTE: Original package / source metadata indicates license is: MIT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d4e0c95fd7768def1f82add7c967c60 \
                   "

SRC_URI = "git://github.com/marshmallow-code/marshmallow-sqlalchemy.git;protocol=https;nobranch=1"

# Modify these as desired
PV = "0.26.1+git${SRCPV}"
SRCREV = "98ae5ed47089a1150852c4eb47c98235ea8f128a"

S = "${WORKDIR}/git"

inherit setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-datetime python3-netclient python3-numbers"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    marshmallow
#    marshmallow_sqlalchemy
#    marshmallow_sqlalchemy.exceptions
#    marshmallow_sqlalchemy.fields
#    pytest
#    sqlalchemy
#    sqlalchemy.dialects
#    sqlalchemy.dialects.postgresql
#    sqlalchemy.ext.associationproxy
#    sqlalchemy.ext.declarative
#    sqlalchemy.orm


