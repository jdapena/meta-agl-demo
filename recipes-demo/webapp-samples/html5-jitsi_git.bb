SUMMARY     = "AGL HTML5 Jitsi"
LICENSE     = "CLOSED"
DESKTOP_FILE = "webapps-jitsi.desktop"

require webapp-samples.inc

do_install:append() {
  cp -R --no-dereference --preserve=mode,links ${S}/jitsi/* ${D}${WAM_APPLICATIONS_DIR}/${PN}
}

