package study.inClass;

import inClass.ValidationUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    void 야구_숫자_1에서_9_검증() {
        //경계값 테스트
        assertThat(ValidationUtil.validNo(9)).isTrue();
        assertThat(ValidationUtil.validNo(1)).isTrue();
        assertThat(ValidationUtil.validNo(0)).isFalse();
        assertThat(ValidationUtil.validNo(10)).isFalse();
    }
}
