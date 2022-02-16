SUMMARY = "The software for DEMO platform of AGL IVI profile"
DESCRIPTION = "A set of packages belong to AGL Demo Platform"

LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-demo-platform-html5 \
    packagegroup-agl-demo-platform-html5-devel \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-image-ivi \
    "

RDEPENDS:${PN} += "\
    packagegroup-hmi-framework \
    packagegroup-agl-profile-graphical-html5 \
    packagegroup-agl-demo \
    "


RDEPENDS:${PN}:append = " \
    weston-ini-conf \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip' , '', d)} \
    "

# NOTE: Currently no coverage versions for the application widgets,
#       they should be added here when available.
#       Also, the navigation and mixer debug widgets are currently
#       specified explicitly, as there's no simple way to derive their
#       names from the virtual/ RPROVIDES at present.
RDEPENDS:${PN}-devel = " \
    packagegroup-hmi-framework-devel \
    "

# TODO(jdapena): replace this with HTML5 apps.
AGL_APPS = " \
    dashboard \
    html5-launcher \
    html5-hvac \
    ondemandnavi \
    settings \
    "

# TODO(jdapena): review if we still need the demo-i2c stuff.

# Hook for demo platform configuration
# ATM used for:
# 1) Adding udev configuration and scripts for supporting USB attached
#    I2C devices for RTC and HVAC LED support.
DEMO_UNIT_CONF ?= "demo-i2c-udev-conf"

# Preload only if agl-demo-preload is set
DEMO_PRELOAD = "${@bb.utils.contains("AGL_FEATURES", "agl-demo-preload", "${DEMO_UNIT_CONF}", "",d)}"

RDEPENDS:${PN}:append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'unzip' , '', d)} \
    qtquickcontrols2-agl \
    qtquickcontrols2-agl-style \
    ${AGL_APPS} \
    ${DEMO_PRELOAD} \
    "
