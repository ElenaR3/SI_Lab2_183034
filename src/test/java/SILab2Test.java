import com.intellij.openapi.vcs.history.VcsRevisionNumber;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.util.ReflectionUtils;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Angle> createList(Angle... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }


    @Test
    void everyStatementTest() {

        Angle agol1= new Angle(180, 60, 40);
        Angle agol2= new Angle(180, 30,20);
        List<Angle> lista1= createList(agol1,agol2);

        RuntimeException ex;
        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista1);
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        agol1=new Angle(180, -1, 5);
        agol2=new Angle(180, 20, 20);
        List<Angle> lista2=createList(agol1, agol2);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista2));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        agol1=new Angle(180, 20, -5);
        agol2=new Angle(180, 20, 20);
        List<Angle> lista3=createList(agol1, agol2);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista3));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));


        agol1=new Angle(180, 20, 65);
        agol2=new Angle(180, 20, 20);
        List<Angle> lista4=createList(agol1, agol2);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista4));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));

        agol1=new Angle(180, 20, 30);
        agol2=new Angle(60, 20, 20);
        List<Angle> lista5=createList(agol1, agol2);
        List<Integer> expected = new ArrayList<>();
        expected.add(649230);
        expected.add(217220);
        List<Integer> result= SILab2.function(lista5);
        Assert.assertThat(result, is(expected));
        assertEquals(result, expected);
        Assert.assertThat(result, hasItems(2));    //proveruva dali listata go ima ocekuvaniot broj na elementi


        agol1=new Angle(360, 0, 0);
        List<Angle> lista6=createList(agol1);
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(1296000);
        List<Integer> result1= SILab2.function(lista6);
        Assert.assertThat(result1, is(expected1));
        assertEquals(result1, expected1);
        Assert.assertThat(result1, hasItems(1));

        agol1=new Angle(360, 20, 65);
        List<Angle> lista7=createList(agol1);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista7));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));


        agol1=new Angle(-5, 20, 65);
        List<Angle> lista8=createList(agol1);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista8));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));


        agol2= new Angle(400, 20, 1);
        List<Angle> lista9= createList(agol2);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista9));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));

    }

    @Test
    void MultipleCondition(){

        RuntimeException ex;
        Angle agol1= new Angle(400, 60, 40);
        Angle agol2= new Angle(360, 30,20);
        List<Angle> lista1= createList(agol1);
        List<Angle> lista2= createList(agol2);
        
        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista1);
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista2)));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));

        agol1= new Angle(180, 60, 40);
        agol2= new Angle(180, 30,70);
        List<Angle> lista3= createList(agol1);
        List<Angle> lista4= createList(agol2);

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista3);
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        ex= assertThrows(RuntimeException.class, () -> SILab2.function(lista3);
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid\""));

        agol1=new Angle(180, 20, 30);
        agol2=new Angle(60, 20, 20);
        List<Angle> lista5=createList(agol1, agol2);
        List<Integer> expected = new ArrayList<>();
        expected.add(649230);
        expected.add(217220);
        List<Integer> result= SILab2.function(lista5);
        Assert.assertThat(result, is(expected));
        assertEquals(result, expected);
        Assert.assertThat(result, hasItems(2));



    }


}