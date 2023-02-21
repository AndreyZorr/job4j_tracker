package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rls = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                rls.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return rls.toString();
    }

    private String getDescendingElements() {
        StringBuilder rls = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            rls.append(descendingElements.pollLast());
        }
        return rls.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}