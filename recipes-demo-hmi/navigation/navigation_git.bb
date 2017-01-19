SUMMARY     = "AGL Reference Navigation application."
DESCRIPTION = "This application provides the function of Navigation to AGL. "
HOMEPAGE    = "http://agl.wismobi.com/"
SECTION     = "apps"

LICENSE="GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=3595e9c703a847d990664d2b396a9df0 \
                  file://COPYING;md5=947b2d60ca3872e172034438e9801200"

DEPENDS = " \
          glib-2.0 freetype sqlite3 wayland zlib expat openssl virtual/libgles2 virtual/libgl virtual/egl \
          wayland libdbus-c++ af-main \
          "

RDEPENDS_${PN} = " flite openjtalk "

SRCREV="3dc643168cfa8ea0028b53770351a1fa608265c1"
SRC_URI="git://github.com/AGLExport/gpsnavi.git;branch=agl \
         file://flite.in \
         file://jtalk.in \
         file://download_mapdata_jp.sh \
         file://download_mapdata_uk.sh \
"

# To avoid C++ library link failure
SECURITY_CFLAGS = ""

inherit autotools pkgconfig

S = "${WORKDIR}/git"

do_compile_prepend() {
   cp ${WORKDIR}/flite.in ${S}/
   cp ${WORKDIR}/jtalk.in ${S}/
}

do_install_append() {
   install -d ${D}/usr/AGL/apps
   install -m 0644 ${B}/navigation.wgt ${D}/usr/AGL/apps/
   install -m 0755 ${WORKDIR}/download_mapdata_jp.sh ${D}/usr/AGL/apps/
   install -m 0755 ${WORKDIR}/download_mapdata_uk.sh ${D}/usr/AGL/apps/

   install -d ${D}/var/mapdata
}

FILES_${PN} += " /usr/AGL/apps/* /var/mapdata "
