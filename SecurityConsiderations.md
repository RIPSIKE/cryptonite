## Exporting and opening files ##

The following restrictions apply when you're decrypting local or remote EncFS volumes using the "Decrypt folder" buttons. They don't apply when you're _mounting_ local EncFS or TrueCrypt volumes.

Obviously, when you're exporting files from EncFS volumes you'll end up with a decrypted copy of your file. If you're exporting it to your sdcard, it will typically be readable by anyone who has access to your phone and by any application that has access to your sdcard.

Less obviously, when you're opening a file from a decrypted EncFS volume, Cryptonite will produce a temporary copy in /data/data/csh.cryptonite/app\_open/path\_to\_your\_file. This decrypted file is world-readable and will only be deleted when you press the "Forget decryption" button or uninstall Cryptonite. A local copy is needed because most (if not all) file viewing apps (Text Editors, Gallery, etc.) require a physical copy of your file on world-readable storage. To bypass this issue, Cryptonite includes a simple text file viewer that will open text files in memory without using temporary files. On the long run, I'm planning to include a basic image viewer as well.

If you're using a rooted phone that supports FUSE, mounting an EncFS volume is a safer and more comfortable way to access your files because they will be transparently decrypted on-the-fly without being written to disk.