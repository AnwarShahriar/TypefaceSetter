## Deprecated
>This project is not actively maintained anymore. I've found a new home for it and it's call "". Please use "" to set your type face.

Though it’s not a complete work and a lot of work still needed but you can go through the code and off-course fork it.

Place your custom font in the assets folder and for any activity just write these two lines of code after calling setContentView:

```java
TypefaceSetter setter = new TypefaceSetter(this, "your font path");
setter.setTypeface();
```

Voila! you’re done for setting typeface for your entire ViewHierarchy. Just Check it out and let me know your thought so that I can improve it. Thank you.
