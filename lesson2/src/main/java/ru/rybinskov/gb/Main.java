package ru.rybinskov.gb;

public class Main {
    public static void main(String[] args) {
//        MyList<Integer> list = new SimpleArrayList<>();
//        list.add(5);
//        Integer a = 5;
//        System.out.println(list.toString());
//        System.out.println(list.remove(a));
//        System.out.println(list.toString());
//
//        list.add(8);
//        System.out.println(list.toString());
//        System.out.println(list.remove(0));
//        System.out.println(list.toString());
//
//        list.clear();
//        System.out.println(list.toString());
//
//        MyList<Integer> list2 = new SimpleArrayList<>(5);
//        list2.add(a, 4);
//        System.out.println(list2.toString());
//        System.out.println(list2.remove(4));
//        System.out.println(list2.toString());

//        --------------------------------------------------------  //

        MyLinkedList<String> linkedList = new SimpleLinkedList<>();
        linkedList.addFirst("aaa");
        linkedList.addFirst("bbb");
        linkedList.addFirst("ccc");
        linkedList.addFirst("ddd");

        linkedList.addLast("last");
        linkedList.addLast("last2");
        linkedList.addLast("last3");
        System.out.println(linkedList.toString());


        System.out.println("Удаляем первый элемент: " + linkedList.removeFirst());
        System.out.println(linkedList.toString());

        System.out.println("Проверка на наличие \"bbb\" в списке: " + linkedList.contains("bbb"));

        System.out.println("Проверяем первый элемент: " + linkedList.getFirst());
        System.out.println("Проверяем последний элемент: " + linkedList.getLast());
        System.out.println("Удаляем последний элемент: " + linkedList.removeLast());
        System.out.println("Проверяем последний элемент: " + linkedList.getLast());
        System.out.println("Проверяем итоговый список: " + linkedList.toString());
    }
}
