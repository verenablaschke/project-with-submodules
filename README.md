Set-up:
- In the root folder, run `git submodule add https://github.com/verenablaschke/submodule-from-root submodule-from-root`
- Update the Eclipse project
- Add  `submodule-from-root/src/java/main` to the build path
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


---

https://github.blog/2016-02-01-working-with-submodules/