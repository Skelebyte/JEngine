package JEngine;

public enum Key {

    KEY_NULL(0),

    KEY_ENTER(10),
    KEY_SHIFT(16),
    KEY_ESC(27),
    KEY_SPACE(32),

    KEY_LEFT(37),
    KEY_UP(38),
    KEY_RIGHT(39),
    KEY_DOWN(40),

    KEY_0(48),
    KEY_1(49),
    KEY_2(50),
    KEY_3(51),
    KEY_4(52),
    KEY_5(53),
    KEY_6(54),
    KEY_7(55),
    KEY_8(56),
    KEY_9(57),

    KEY_A(65),
    KEY_B(66),
    KEY_C(67),
    KEY_D(68),
    KEY_E(69),
    KEY_F(70),
    KEY_G(71),
    KEY_H(72),
    KEY_I(73),
    KEY_J(74),
    KEY_K(75),
    KEY_L(76),
    KEY_M(77),
    KEY_N(78),
    KEY_O(79),
    KEY_P(80),
    KEY_Q(81),
    KEY_R(82),
    KEY_S(83),
    KEY_T(84),
    KEY_U(85),
    KEY_V(86),
    KEY_W(87),
    KEY_X(88),
    KEY_Y(89),
    KEY_Z(90),

    NUMPAD_0(96),
    NUMPAD_1(96),
    NUMPAD_2(96),
    NUMPAD_3(96),
    NUMPAD_4(96),
    NUMPAD_5(96),
    NUMPAD_6(96),
    NUMPAD_7(96),
    NUMPAD_8(96),
    NUMPAD_9(96);

    final int keyCode;

    Key(int code) {
        this.keyCode = code;
    }

}