SUMMARY     = "AGL Qt AppFW Library"
DESCRIPTION = "libqtappfw"
HOMEPAGE    = "http://docs.automotivelinux.org"
SECTION     = "libs"

LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = " \
    qtbase \
    qtdeclarative \
    glib-2.0 \
    bluez-glib \
    connman-glib \
    libmpdclient \
"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/libqtappfw;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "5ef90db242ad29c9772f2237b477c58ef65545c7"
S       = "${WORKDIR}/git"

# PV needs to be modified with SRCPV to work AUTOREV correctly
PV = "2.0+git${SRCPV}"

inherit cmake_qt5 pkgconfig

RRECOMMENDS:${PN} += "bluez5 connman mpd"

BBCLASSEXTEND = "nativesdk"
