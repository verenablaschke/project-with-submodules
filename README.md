# Set-up:
- In the root folder, run `git submodule add https://github.com/verenablaschke/submodule-from-root submodule-from-root` (No need to set up any additionally local folders for the submodule! This already clones the submodule into a folder inside the local main module directory.)
- Update the Eclipse project and add  `submodule-from-root/src/main/java` to the build path
- You can now import code from the submodule into the main module and vice versa using the normal package structure:

`App.java` (in the main module)
```
package de.tuebingen.sfs.submoduledemo;

import de.tuebingen.sfs.submodulefromroot.SubmoduleFromRoot;

public class App {
    public static void main(String args[]) {
        greet();
        SubmoduleFromRoot.greet();
    }
    
    public static void greet(){
        System.out.println("Running the main project");
    }
}
```

`SubmoduleFromRoot.java` (in the submodule)
```
package de.tuebingen.sfs.submodulefromroot;

import de.tuebingen.sfs.submoduledemo.App;

public class SubmoduleFromRoot {

    public static void main(String args[]) {
        greet();
        App.greet();
    }

    public static void greet() {
        System.out.println("Running the submodule with full folder structure");
    }
}
```

# Updating the code:

Inside the main module, `git add/commit/push` only works for the files belonging to the main module. If a submodule contains changes,  `git status` in the main module will include that information as `submodule-from-root (modified content)`.

To update the submodule remote, navigate into the corresponding folder and use `git add/commit/push` there. Returning to the main folder and running `git status` there informs you that `submodule-from-root (new commits)`. Run `git add/commit/push` on the submodule's folder to update the version that's used in the remote (the commit hash on the submodule link on the GitHub repo view will change).

If someone else changed the contents of a submodule, but not the link in the remote, use `git checkout master && git pull` inside the submodule to get it up to date in your workspace, and then follow the instructions in the previous paragraph to update the link in the remote.

If someone else updated the submodule link in the remote, run `git submodule update --recursive` in the main folder to work with the updated version.

# Initializing nested submodules

```
git submodule update --init --recursive
```

---

https://github.blog/2016-02-01-working-with-submodules/