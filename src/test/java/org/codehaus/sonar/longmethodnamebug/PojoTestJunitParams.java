package org.codehaus.sonar.longmethodnamebug;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junitparams.JUnitParamsRunner.$;

/**
 * Use junitparams library (JUnitParamsRunner.class) for parameterized tests.
 */
@RunWith(JUnitParamsRunner.class)
public class PojoTestJunitParams {
    private static final Logger LOG = LoggerFactory.getLogger(PojoTestJunitParams.class);
    
    private Pojo pojo;
    
    @Before
    public void before() {
        pojo = new Pojo();
    }
    
    @Test
    @Parameters
    public void testDescription(int id, String description) {
        pojo.setId(id);
        pojo.setDescription(description);
        
        LOG.info("description.length(): " + description.length());
        LOG.info("pojo.getDescription(): " + pojo.getDescription());
    }

    public Object[] parametersForTestDescription() {
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

        return $(
                $(1, "short desc"),
                $(2, longDescription)
        );
    }
}
