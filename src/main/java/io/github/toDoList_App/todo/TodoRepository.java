package io.github.toDoList_App.todo;

import io.github.toDoList_App.HibernateUtil;
import io.github.toDoList_App.lang.Lang;

import java.util.List;
import java.util.Optional;

class TodoRepository {

    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Todo", Todo.class).list();

        transaction.commit();
        session.close();
        return result;
    }
    Todo toggleToDo (Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Todo.class, id);
        result.setDone(!result.isDone());

        transaction.commit();
        session.close();
        return result;
    }

    Todo addTodo (Todo newTodo) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.persist(newTodo);

        transaction.commit();
        session.close();
        return newTodo;
    }

    public Todo deleteTodo(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var todo = session.get(Todo.class, id);
        session.delete(todo);

        transaction.commit();
        session.close();
        return todo;
    }

}
