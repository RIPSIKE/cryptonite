### 0.7.7-0.7.10 ALPHA ###
  * Fix a bug where some decrypted Dropbox folders would be empty.
  * Update openssl, encfs, and Dropbox SDK to the latest versions.
  * Support encfs files <= v5
  * Add superuser permission to manifest

### 0.7.6 BETA ###
  * Enable arbitrary external source directories when mounting EncFS volumes.

### 0.7.5 BETA ###
  * Improve support for external mounts other than /mnt/sdcard.
  * Fix creating local EncFS volumes.

### 0.7.4 BETA ###
  * Fixes an fc that would sometimes occur when creating Dropbox volumes. Thanks for reporting.

### 0.7.3 BETA ###
  * Fixes an fc when the database can't be opened. Thanks for reporting.

### 0.7.2 BETA ###
  * No changes over 0.7.1.

### 0.7.1 ALPHA ###
  * Ask before selecting external config file.
  * Simplify button logic.

### 0.7.0 ALPHA ###
  * Save default EncFS volume settings.
  * Support external EncFS configuration files.
  * Fixed several bugs reported through Google Play.

### 0.6.17 BETA ###
  * Increase file pointer size in EncFS to support > 2GB.

### 0.6.16 ALPHA ###
  * More fixes to TrueCrypt to support volumes > 2GB. Thanks to il2am0000 for the patch.

### 0.6.15 ALPHA ###
  * Fixed an fc that would rarely occur when decoding Dropbox files.

### 0.6.14 ALPHA ###
  * Built with latest SDK (20.x) and NDK (r8b)

### 0.6.13 ALPHA ###
  * TrueCrypt now supports volumes > 2GB. Thanks to pkalny for the patch.
  * Fixed FCs that would sometimes occur when initializing EncFS volumes, uploading files, or browsing directories. Thanks for reporting.

### 0.6.12 BETA ###
  * Fixed an fc that would rarely occur when an external cache directory was selected. Thanks for reporting.

### 0.6.11 BETA ###
  * Fixed an fc that would occur on some device when denying root rights. Thanks for reporting.

### 0.6.10 BETA ###
  * Added option to delete cached files. Thanks for the suggestion.

### 0.6.9 BETA ###
  * Allow opening absurdly large files. Thanks for the suggestion.

### 0.6.8 BETA ###
  * Updated Dropbox SDK and other libraries.

### 0.6.7 BETA ###
  * Fixed an fc when running out of memory during safe text preview. Thanks for reporting.
  * Optionally mount EncFS volumes accepting any key. Thanks to Frédéric Julian for the patch.

### 0.6.6 BETA ###
  * Fixed a rare fc when browsing decrypted volumes. Thanks for reporting.
  * Don't accidentally re-link with Dropbox.
  * Upgraded OpenSSL.

### 0.6.5 BETA ###
  * Optionally make EncFS accept any key. Thanks to Frédéric Julian for the patch.

### 0.6.4 BETA ###
  * Fixed an fc that would rarely occur when uploading files to Dropbox. Thanks for reporting.

### 0.6.3 BETA ###
  * Fixed bug when mounting EncFS volumes. Thanks for reporting and apologies for shipping a broken encfs binary with 0.6.2.

### 0.6.2 BETA ###
  * No changes over 0.6.1

### 0.6.1 ALPHA ###
  * Recover Dropbox connection when application is restarted.
  * Updated OpenSSL.

### 0.6.0 BETA ###
  * Fixed a bug when changing orientation while mounting an EncFS volume.

### 0.5.8 ALPHA ###
  * Fixed a bug when changing orientation while decrypting an EncFS volume.

### 0.5.7 ALPHA ###
  * Fixed an fc when changing orientation while uploading an encrypted file to DB.

### 0.5.6 ALPHA ###
  * Some more bug fixes when changing orientation.

### 0.5.5 ALPHA ###
  * Updated to latest Android Terminal Emulator API.

### 0.5.4 ALPHA ###
  * Fixed a rare bug when attempting to create EncFS volumes.

### 0.5.3 ALPHA ###
  * Fixed a number of bugs and FCs when resuming the app and changing orientation.
  * Use ActionBar on all devices. Create new folders from ActionBar.

### 0.4.5 BETA ###
  * Fixed fc during startup when no external storage is present. Thanks for reporting. Backported from 0.5.0.

### 0.5.2 ALPHA ###
  * Truncate large files for text preview
  * Don't disconnect from Dropbox when returning from preview
  * Reset vfs when changing Dropbox access type

### 0.5.1 ALPHA ###
  * Safe text preview of decrypted data in memory.

### 0.5.0 ALPHA ###
  * Updated user interface using Holo theme on ICS devices.
  * Fixed fc during startup when no external storage is present. Thanks for reporting.
  * Encrypt Dropbox session credentials.

### 0.4.4 BETA ###
  * Problems reported with ICS. Reverted back to previous theme for the time being.

### 0.4.3 BETA ###
  * Fixed some glitches when changing orientation and resuming the app.
  * Use Holo theme on ICS.
  * Upgraded to latest Dropbox SDK.

### 0.4.2 BETA ###
  * Delete files from decrypted EncFS volumes. Thanks for the suggestion.
  * Fixed a bug where Dropbox authentication would be lost when resuming the app. Thanks for reporting.

### 0.4.1 ALPHA ###
  * Launch root terminal

### 0.4.0 ALPHA ###
  * Launch terminal emulator with encfs and tc in PATH.
  * Added tc binary

### 0.3.1 BETA ###
  * Fixed a crash after mount failures. Thanks for reporting.

### 0.3.0 ALPHA ###
  * Cleaned up user interface a bit
  * Confirm password when creating new volumes. Thanks for the suggestion.
  * Fixed a bug where custom mount points would be reverted during program startup

### 0.2.14 BETA ###
  * Fixed some bugs where volumes couldn't be unmounted if the mount point was changed.

### 0.2.13 BETA ###
  * Choose mount point in preferences. Thanks for the suggestion.

### 0.2.12 BETA ###
  * Optionally use restricted app folder access on your Dropbox. Thanks for the suggestion.
  * Fixed some bugs where your preferences would be ignored or deleted.

### 0.2.11 BETA ###
  * Get a bug report if application fails to start on some devices. Thanks for reporting.

### 0.2.10 BETA ###
  * Fixed a crash when mounting folders with spaces in the path name. Thanks for reporting.

### 0.2.9 BETA ###
  * Add option to save temporary files on SD card to save on internal storage space. Thanks for the suggestion.

### 0.2.8 BETA ###
  * Show an error message rather than crashing in some cases when Dropbox can't be read
  * Added new folder button when starting a new EncFS volume on Dropbox

### 0.2.7 BETA ###
  * Fixed a performance issue that would cause the program to freeze when encrypting files
  * Fixed a major bug when exporting files recursively
  * Fixed some bugs that would cause the program to freeze when opening files and after password entry

### 0.2.6 BETA ###
  * Fixed a bug that caused garbage to be appended to some uploaded files during encryption

### 0.2.5 BETA ###
  * Fixed a crash when opening files without an extension

### 0.2.4 BETA ###
  * Fixed a crash when uploading files without an extension

### 0.2.2 and 0.2.3 BETA ###
  * Fixed a potential crash when creating new EncFS volumes. Thanks for reporting.
  * Fixed button state bug

### 0.2.1 BETA ###
  * Fixed a potential crash during startup. Thanks for reporting.

### 0.2.0 BETA ###
  * Create EncFS volumes from scratch

### 0.1.2 BETA ###
  * Create new folders in EncFS volumes

### 0.1.1 BETA ###
  * Fixed a crash on Android 2.2 (Froyo)
  * Better performance on devices with more recent CPUs
  * Bundled with OpenSSL library to avoid incompatibilities

### 0.1.0 BETA ###
  * Initial Market release