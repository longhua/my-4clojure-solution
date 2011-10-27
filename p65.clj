; Black Box Testing
; Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.
;
; Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.
; You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
;
(fn [coll]
  (let [first-char (first (pr-str coll))]
    (cond (= first-char \{) :map
          (= first-char \() :list
          (= first-char \[) :vector
          (= first-char \#) :set
          :else (throw (Exception. "Not a sequence")))))
