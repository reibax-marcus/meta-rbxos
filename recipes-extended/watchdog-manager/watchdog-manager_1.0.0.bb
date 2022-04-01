# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

DESCRIPTION = "Userspace Watchdog management tool"
SUMMARY = "Userspace Watchdog management tool"
AUTHOR = "Antoine Dugast, Xabier Marquiegui"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc0ead9603bf2ff2bad1ebf74b5c2399"

SRC_URI = "git://github.com/reibax-marcus/watchdog.git;protocol=https;branch=develop"

# Modify these as desired
PV = "1.0.0+git${SRCPV}"
SRCREV = "6f325372a525f985464ed5898b1d72d3a7ea1c3b"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""
