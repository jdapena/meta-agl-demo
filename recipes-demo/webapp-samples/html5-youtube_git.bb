SUMMARY     = "AGL HTML5 Youtube"
LICENSE     = "CLOSED"
DESKTOP_FILE = "webapps-youtube.desktop"

require webapp-samples.inc

do_install:append() {
  cp -R --no-dereference --preserve=mode,links ${S}/youtube/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
}

