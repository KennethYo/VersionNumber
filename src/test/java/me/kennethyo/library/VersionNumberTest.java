package me.kennethyo.library;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class VersionNumberTest {
    private static final int MAJOR = 1;
    private static final int MINOR = 0;
    private static final int MICRO = 1;
    private static final int PATCH = 6;
    private static final String QUALIFIER = "release";

    private static final String BASE_VERSION = MAJOR + "." + MINOR + "." + MICRO;
    private static final String VERSION = BASE_VERSION + "." + PATCH + "-" + QUALIFIER;

    @Test
    public void getMajor() {
        VersionNumber versionNumber = VersionNumber.parse(VERSION);

        Assert.assertEquals(MAJOR, versionNumber.getMajor());
    }

    @Test
    public void getMinor() {
        VersionNumber versionNumber = VersionNumber.parse(VERSION);

        Assert.assertEquals(MINOR, versionNumber.getMinor());
    }

    @Test
    public void getMicro() {
        VersionNumber versionNumber = VersionNumber.parse(VERSION);

        Assert.assertEquals(MICRO, versionNumber.getMicro());
    }

    @Test
    public void getPatch() {
        VersionNumber versionNumber =  VersionNumber.withPatchNumber().parse(VERSION);

        Assert.assertEquals(PATCH, versionNumber.getPatch());
    }

    @Test
    public void getQualifier() {
        VersionNumber versionNumber = VersionNumber.withPatchNumber().parse(VERSION);

        Assert.assertEquals(QUALIFIER, versionNumber.getQualifier());
    }

    @Test
    public void getBaseVersion() {
        VersionNumber versionNumber = VersionNumber.parse(VERSION);
        VersionNumber baserVersionNumber = VersionNumber.parse(BASE_VERSION);
        Assert.assertEquals(baserVersionNumber, versionNumber.getBaseVersion());
    }
}
