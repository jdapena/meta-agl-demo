SUMMARY = "The middlewares for AGL IVI profile"
DESCRIPTION = "The set of packages required by Connectivity Subsystem"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-ivi-connectivity \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    bluez5-obex \
    ${@bb.utils.contains("DISTRO_FEATURES", "3g", "libqmi", "", d)} \
    rtl-sdr \
    ofono \
    "
