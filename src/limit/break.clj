(ns limit.break
  (:require [clojure.main]))

(def ^:dynamic *level* 0)

(defmacro local-bindings
  "Produces a map of the names of local bindings to their values."
  []
  (let [symbols (keys &env)]
    (zipmap (map (fn [sym] `(quote ~sym)) symbols) symbols)))

(def ^:dynamic *locals*)

(defn eval-with-locals
  "Evals a form with given locals. The locals should be a map of symbols to
values."
  [locals form]
  (binding [*locals* locals]
    (eval
     `(let ~(vec (mapcat #(list % `(*locals* '~%)) (keys locals)))
        ~form))))

(defn prompt []
  (print (if (= 1 *level*) ; get fancy only if we're nesting
           "break> "
           (str "break-" *level* "> "))))

(defmacro break []
  `(let [eval-fn# (partial eval-with-locals (local-bindings))]
     (binding [*level* (inc *level*)]
       ;; TODO: nrepl-friendly :read function
       (clojure.main/repl :prompt prompt :eval eval-fn#))))
