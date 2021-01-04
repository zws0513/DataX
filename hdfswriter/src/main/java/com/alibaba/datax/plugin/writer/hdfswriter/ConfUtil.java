package com.alibaba.datax.plugin.writer.hdfswriter;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.datax.common.util.Configuration;

public class ConfUtil {
  public static String getTempDirectory(String pluginType, String pluginName) {
    String pluginJsonPath = StringUtils.join(
        new String[] {System.getProperty("datax.home"), "plugin",
            pluginType,
            String.format("%s%s", pluginName, pluginType),
            "plugin.json"}, File.separator);
    Configuration configuration = Configuration.from(new File(
        pluginJsonPath));
    return configuration.getString("tempDirectory");
  }
}
