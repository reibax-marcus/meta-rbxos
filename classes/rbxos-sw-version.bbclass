#
# Generates RBXOS_SW_VERSION variable that can be used as a system version variable
#
#Expected tag format (in git repository):
# 0.0.0+alpha1
#Expected version format examples for get_version_from_git():
# 0.0.0+alpha1+d20141203
# 0.0.0+alpha0.645.gb7c11ab+d20141203
#

# Determines if HEAD of given path is on a git tag or not
def is_git_tag(path):
    import subprocess
    try:
        subprocess.check_output("cd %s; git describe --exact-match --tags HEAD" % path,
                                shell=True,
                                stderr=subprocess.STDOUT)
        return True
    except subprocess.CalledProcessError as ex:
        return False

# Get git describe string in selected path
def git_get_describe(path):
    import subprocess
    try:
        output = subprocess.check_output("cd %s ; if [ $(git status -s | wc -l) -ne 0 ] ; \
                then echo $(git describe)mod ; else git describe ; fi" % path,
                                        shell=True,
                                        stderr=subprocess.STDOUT)
        return output.decode('utf-8').strip('\n')
    except:
        raise

# Get git describe base tag
def git_get_describe_basetag(path):
    import subprocess
    try:
        output = subprocess.check_output("cd %s; git describe --abbrev=0" % path,
                                        shell=True,
                                        stderr=subprocess.STDOUT)
        return output.decode('utf-8').strip('\n')
    except:
        raise

# Get git HEAD date in format YYYYMMDD
def git_get_head_date(path):
    import subprocess
    try:
        output = subprocess.check_output("cd %s && date -d \"$(git show -s \
                --format=%%ci)\" \"+%%Y%%m%%d\"" % path, shell=True, stderr=subprocess.STDOUT)
        return output.decode('utf-8').strip('\n')
    except:
        raise

# Calculate rbxos version string, and put it in RBXOS_SW_VERSION
def get_rbxos_version(d):
    try:
        rbxos_version_override = d.getVar('RBXOS_PRJ_VERSIONOVERRIDE', True)
        if rbxos_version_override:
            return rbxos_version_override
        topdir_path = d.getVar('RBXOS_PRJ_TOPDIR', True)
        topdir_gitdescribe = git_get_describe(topdir_path).replace('-', '.')
        topdir_gitdate = git_get_head_date(topdir_path)
        rbxos_version = topdir_gitdescribe + '+d' + topdir_gitdate
        return rbxos_version
    except:
        raise

RBXOS_SW_VERSION = "${@get_rbxos_version(d)}"

