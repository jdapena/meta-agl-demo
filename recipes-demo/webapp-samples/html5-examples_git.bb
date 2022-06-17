SUMMARY     = "AGL HTML5 Examples"
LICENSE     = "CLOSED"
DESKTOP_FILE = "webapps-examples.desktop"

require webapp-samples.inc

do_install:append() {
  cp -R --no-dereference --preserve=mode,links ${S}/examples/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
}

