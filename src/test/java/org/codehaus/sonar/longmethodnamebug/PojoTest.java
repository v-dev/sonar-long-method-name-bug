package org.codehaus.sonar.longmethodnamebug;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PojoTest {
    private static final Logger LOG = LoggerFactory.getLogger(PojoTest.class);
    
    private Pojo pojo;
    
    @Before
    public void before() {
        pojo = new Pojo();
    }
    
    @Test
    public void shortDescription() {
        String shortDescription = "short desc";
        pojo.setDescription(shortDescription);

        LOG.info("pojo: " + pojo.getDescription());
    }

    @Test
    public void longDescription() {
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
        pojo.setDescription(longDescription);

        LOG.info("longDescription.length(): " + longDescription.length());
        LOG.info("pojo: " + pojo.getDescription());
    }
}
