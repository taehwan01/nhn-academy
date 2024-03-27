package com.nhnacademy;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class MyOptions extends Options {
        private Options options;

        public MyOptions() {
                options = new Options();
                setOptions();
        }

        public Options getMyOptions() {
                return options;
        }

        public void setOptions() {
                Option showHeaderOption = Option.builder("v")
                                .longOpt("verbose")
                                .hasArg(false)
                                .desc("요청, 응답 헤더를 출력한다.")
                                .build();
                options.addOption(showHeaderOption);

                Option headerOption = Option.builder("H")
                                .longOpt("header")
                                .hasArg()
                                .argName("line")
                                .desc("임의의 헤더를 서버로 전송한다.")
                                .build();
                options.addOption(headerOption);

                Option dataOption = Option.builder("d")
                                .longOpt("data")
                                .hasArg()
                                .argName("data")
                                .desc("POST, PUT 등에 데이터를 전송한다.")
                                .build();
                options.addOption(dataOption);

                Option requestOption = Option.builder("X")
                                .longOpt("request")
                                .hasArg()
                                .argName("command")
                                .desc("사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET")
                                .build();
                options.addOption(requestOption);

                Option redirectionOption = Option.builder("L")
                                .longOpt("redirect")
                                .hasArg(false)
                                .desc("서버의 응답이 30x 계열이면 다음 응답을 따라 간다.")
                                .build();
                options.addOption(redirectionOption);

                Option formOption = Option.builder("F")
                                .longOpt("file")
                                .hasArg()
                                .argName("content")
                                .desc("multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.")
                                .build();
                options.addOption(formOption);
        }
}
