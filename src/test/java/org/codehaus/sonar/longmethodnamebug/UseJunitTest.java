package org.codehaus.sonar.longmethodnamebug;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 * Use standard Junit Parameterized library (Parameterized.class) for running the tests.
 */
@RunWith(Parameterized.class)
public class UseJunitTest {
    private static final Logger LOG = LoggerFactory.getLogger(UseJunitTest.class);

    private int id;
    private String description;

    private Pojo pojo;

    public UseJunitTest(int id, String description) {
        this.id = id;
        this.description = description;

        pojo = new Pojo();
    }

    @Test
    public void testDescription() {
        pojo.setId(id);
        pojo.setDescription(description);

        LOG.info("description.length(): " + description.length());
        LOG.info("pojo.getDescription(): " + pojo.getDescription());
    }

    @Parameterized.Parameters
    public static Collection parametersForTestDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut dignissim fringilla fermentum. ");
        sb.append("Ut a nunc lacinia, porttitor enim in, facilisis sapien. ");
        sb.append("Integer malesuada, nisi eu sagittis accumsan, dui mauris tempor risus, eu lacinia tellus nisl ut dui. Nullam id massa id lectus faucibus laoreet. ");
        sb.append("Phasellus eget magna sapien. Nam fermentum leo sit amet vestibulum pharetra. ");
        sb.append("Nulla ac elementum felis. ");
        sb.append("Vestibulum hendrerit commodo nulla, vitae porta justo aliquet vitae. ");
        sb.append("Ut sed nibh dolor. ");
        sb.append("Mauris porta justo quis felis euismod, ut ullamcorper tortor congue.");

        String longDescription = sb.toString();

        return Arrays.asList(new Object[][]{
                {1, "short desc"},
                {2, longDescription}
        });
    }
}
