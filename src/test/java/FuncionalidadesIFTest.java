import ifpb.testesw.FuncionalidadesIF;
import ifpb.testesw.Sistema;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class FuncionalidadesIFTest {

    private static final FuncionalidadesIF target = new Sistema();

    @Test()
    public void validacoesDeCriacaoDoUsuario() {
        // Todos os parametros invalidos
        assertNull(target.cadastraUsuario(
                "",
                "",
                ""
        ));
        // Alguns parametros invalidos
        assertNull(target.cadastraUsuario(
                "Arthur",
                "123312331233",
                "123312331233"
        ));

        // Alguns parametros invalidos
        assertNull(target.cadastraUsuario(
                "Arthur",
                "123312331233",
                "AAAbbb###"
        ));

        assertNull(target.cadastraUsuario(
                "Arthur",
                "arthur.mts@email.com",
                "12345"
        ));
    }

    @Test()
    public void criacaoDoUsuario() {
        assertNotNull(target.cadastraUsuario(
                "Arthur",
                "arthur.mts@email.com",
                "Ab123###111a"
        ));
    }

    @Test()
    public void validacoesFuncaoDeSegundoGrau() {

        assertNull(target.calculaFuncaoSegundoGrau(
                0,
                15,
                2
        ));

        assertNull(target.calculaFuncaoSegundoGrau(
                -2,
                -3,
                -10
        ));
    }

    @Test()
    public void funcaoDeSegudoGrau() {
        var res = target.calculaFuncaoSegundoGrau(
                -2,
                -3,
                15
        );


        assertNotNull(
                res
        );
    }

    @Test()
    public void ehTriangulo() {
        assertFalse(target.ehTriangulo(0, 0, 0));
        assertFalse(target.ehTriangulo(200, 0, 0));
        assertFalse(target.ehTriangulo(180, 0, 180));
        assertFalse(target.ehTriangulo(0, 0, 180));
        assertTrue(target.ehTriangulo(20, 10, 150));

    }

    @Test()
    public void classificaTriangulo() {
        var msgErro = "não tem classificação";
        assertEquals(target.classificaTriangulo(0, 0, 0), msgErro);

        assertTrue(target.classificaTriangulo(90, 45, 45).contains("retângulo"));

        assertTrue(target.classificaTriangulo(70, 70, 40).contains("acutângulo"));

        assertTrue(target.classificaTriangulo(100, 40, 40).contains("obtusângulo"));
    }

    @Test()
    public void ehTrianguloRetangulo() {
        assertFalse(target.ehTrianguloRetangulo(0, 0, 0));
        assertFalse(target.ehTrianguloRetangulo(10, 5, 5));
        assertTrue(target.ehTrianguloRetangulo(10, 8, 6));
    }

    @Test()
    public void ehRetangulo() {
        assertTrue(target.ehRetangulo(90, 90, 90, 90));
        assertFalse(target.ehRetangulo(0, -10, 1233123123, 331293));
    }

    @Test()
    public void perimetroRetangulo() {
        assertNotNull(target.perimetroRetangulo(200, 19));
        assertNotNull(target.perimetroRetangulo(-100, -10000.123));
    }

    @Test()
    public void areaRetangulo() {
        assertNotNull(target.areaRetangulo(12, 12));
        assertNotNull(target.areaRetangulo(-10, -1000));
    }

    @Test()
    public void validacaoCalculadora() {
        assertEquals(target.calculadora("bola + caixa"), "Insira uma expressão válida");
        assertEquals(target.calculadora("123 + caixa"), "Insira uma expressão válida");
        assertEquals(target.calculadora("caixa+123"), "Insira uma expressão válida");
        assertEquals(target.calculadora("1 mais 2"), "expressão invalida, insira uma expressão correta"); //?
        // Estouro matemático
        assertThrows(AssertionFailedError.class, () -> {
            assertEquals(target.calculadora("1000000000000000000000000 + 1"), "1000000000000000000000001.00");

        });
    }

    @Test()
    public void calculadora() {
        assertEquals(target.calculadora("1 + 1"), "2.00");
        assertEquals(target.calculadora("1 / 0"),"∞");
        assertEquals(target.calculadora("1 + 0"), "1.00");
        assertEquals(target.calculadora("1 * 0"), "0.00");
        assertEquals(target.calculadora("1 + -20"), "-19.00");
        assertEquals(target.calculadora("1 / 2"), "0.50");
        assertEquals(target.calculadora("0000000 - 2"), "-2.00");
        assertEquals(target.calculadora("0000000.1 - 0"), "0.10");
        assertEquals(target.calculadora("2 ** 2"), "4.00");
        assertEquals(target.calculadora("1000000000 - 1"), "999999999.00");
    }

    @Test
    public void areaCirculo() {
        assertEquals(target.areaCirculo(10), 314.1592653589793);
        assertEquals(target.areaCirculo(0), 0);
    }

    @Test
    public void perimetroCirculo() {
        // talvez truncar o resultado em menos casas decimais
        assertEquals(target.perimetroCirculo(10), 62.83185307179586);
        assertEquals(target.perimetroCirculo(0), 0);
    }

    @Test
    public void distanciaEntreDoisPontos() {
        assertEquals(target.distanciaEntreDoisPontos(0, 0, 0, 10), 10);
        assertEquals(target.distanciaEntreDoisPontos(0, 0, 100, 0), 100);
        assertEquals(target.distanciaEntreDoisPontos(0, 0, 90000000, 0), 90000000);
    }
}
