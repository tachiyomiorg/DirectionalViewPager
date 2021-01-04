Implementation of a ViewPager that supports both vertical and horizontal swiping.
It's based on the support library 27.1.1 and uses the same package as ViewPager
in order to use its interfaces and make it compatible with adapters and listeners.

A pager can be instantiated either from XML, optionally providing `android:orientation`:

```xml
<androidx.viewpager.widget.DirectionalViewPager
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"/>
```

Or from code:

```kt
val pager = DirectionalViewPager(context, false) // or true for horizontal
```

The direction of the pager can be changed at runtime with:

```kt
pager.setHorizontal(!pager.isHorizontal());
```
