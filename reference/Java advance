https://www.linkedin.com/learning/advanced-java-programming-2/using-wildcards-in-generic-programming?u=2113185

Liskov substitution principle : we can assign the subType variable to the super type, like Class C Extends A ... then A a = new C();
but not allowed ArrayList<A> listA = new ArrayList<C>() --- this is not allowed
Wild Cards: wild cards in java is the unknown type. -- ?
if we want to do above List assignment to make the method common, then we have to use wildcard ArrayList<? extends A> listA = new ArrayList<C>(), we also can use super for reverse, like super type to subType
List<? extends Object> listA = new ArrayList<String>(); || List<? super String> listB = new ArrayList<Object>();
we can use this wild card in the mehtod argument and make a generic method,... but do not use wildcard in reurn type of method, otherwise other developer has to spend time on your hierarchies.

we can pass argument while creating HashMap, Hashtable and LinkedHashMap. HashMap and Hashtable can have max 2 argument(initial capacity and load factor(.75 by default))
LinkedHashMap can have 3rd one along with above 2. 3rd one is boolean (by default false), define the order, false - maintain insertion order /true - maintain access order, modified/accessed last will be at bottom



