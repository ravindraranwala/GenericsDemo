package com.monotonic.generics._4_methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.monotonic.generics._2_collections.Person;
import com.monotonic.generics._3_classes_and_interfaces.before.AgeComparator;

public class SortingExamples
{
    public static void main(String[] args)
    {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        final Person youngestCastMember = min(madMen, new AgeComparator());

        System.out.println(youngestCastMember);
        
        System.out.println(min(Arrays.asList(1, 2, 3), Integer::compare));
    }

    public static <T> T min(List<T> values, Comparator<T> comparator)
    {
        if (values.isEmpty())
        {
            throw new IllegalArgumentException("Unable to find the minimum of an empty list");
        }

        T lowestFound = values.get(0);

        for (int i = 1; i < values.size(); i++)
        {
            final T element = values.get(i);
            if (comparator.compare(element, lowestFound) < 0)
            {
                lowestFound = element;
            }
        }

        return lowestFound;
    }

}
