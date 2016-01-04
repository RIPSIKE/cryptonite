# Dropbox #
  1. **Why do I have to download and then re-upload files to get them synchronized with my encrypted Dropbox folder? I'd like to modify them on the fly.**
> > For two reasons: First, Dropbox doesn't support direct file synchronization on Android. Second, most Android devices don't support FUSE so that EncFS volumes can't be mounted for direct and transparent file encryption and decryption.
> > As a workaround, you can use one of the many apps that provide online storage synchronization (e.g. FolderSync Lite or Dropsync). Setting up a scheduled sync to a local folder and mounting this local folder with Cryptonite will give you something very close to transparent file encryption and decryption.
  1. **How can I access an encrypted Dropbox volume when I'm offline?**
> > Sync them to a local folder with one of the many apps that provide online storage synchronization (e.g. FolderSync Lite or Dropsync). Then, mount that local volume with Cryptonite. This will only work on rooted phones that support FUSE though.
  1. **Why can't I access my full Dropbox?**
> > You probably restricted access to an app folder at some point. To get access to your full Dropbox, disable "Use app folder on Dropbox" in the preferences menu.
# EncFS #
  1. **Why can't I mount EncFS volumes on my Motorola device although I'm running a recent version of Cyanogenmod?**
> > Almost all Motorola kernels are signed and protected. FUSE is not available because CONFIG\_FUSE\_FS is disabled in these signed kernels. It might be possible to build and load fuse.ko as an external kernel module, but I haven't tested it because I don't have access to a Motorola device. Please let me know if you succeed.
  1. **Why can't I mount EncFS volumes on my Google Nexus S device although I'm running a recent version of Cyanogenmod?**
> > This should be fixed in one of the upcoming CM releases. See [this issue](https://code.google.com/p/cryptonite/issues/detail?id=17).
  1. **Why can't I mount EncFS volumes on my Samsung Galaxy S device although I'm running a recent version of Cyanogenmod?**
> > Some kernels for this phone come with a FUSE module that you can load with `modprobe fuse` from a root terminal.
  1. **How can I mount EncFS volumes on a Sony Xperia (Arc/Ray)?**
> > Follow these instructions: http://forum.xda-developers.com/showthread.php?p=28487649#post28487649
  1. **Why do I need root privileges to mount EncFS and TrueCrypt volumes?**
> > At the moment, it requires root because mounting volumes with FUSE requires root on FUSE-enabled Android devices. This is not an absolute requirement. Most desktop Linux distros will allow you to mount truecrypt volumes without root privileges. I've tried to explain that to the CyanogenMod devs, but haven't had any success so far (https://code.google.com/p/cyanogenmod/issues/detail?id=5034). If you want to get non-root support on CyanogenMod, please vote for this enhancement and/or bring it to the attention of the CM devs. On devices that don't come with FUSE, there's little hope to get the original TrueCrypt source to run at all.
# TrueCrypt #
  1. **How can I make TrueCrypt mount my volume with correct permissions? I don't want to use a root file browser.**
> > Try: `truecrypt --fs-options="uid=1000,gid=1000,umask=0002" volume.tc /sdcard/tc`. Thanks to user pkalny for [reporting this fix](https://code.google.com/p/cryptonite/issues/detail?id=32).
  1. **TrueCrypt fails with: "ERROR: Failed to create a file or directory in a temporary directory." Is there a fix?**
> > Create a temporary directory with `mkdir -p /sdcard/Android/data/csh.cryptonite/`. Android doesn't have a standard tmp directory so that we have to use this workaround to provide one.