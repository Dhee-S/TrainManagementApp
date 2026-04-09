import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private final String TRAIN_ID_PATTERN = "TRN-\\d{4}";
    private final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(TRAIN_ID_PATTERN, "TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRAIN12"));
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN12A"));
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET-ab"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET123"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-123"));
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PET-aB"));
        assertTrue(Pattern.matches(CARGO_CODE_PATTERN, "PET-XY"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, ""));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, ""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Pattern.matches(TRAIN_ID_PATTERN, "TRN-1234Extra"));
        assertFalse(Pattern.matches(CARGO_CODE_PATTERN, "PrefixPET-AB"));
    }
}