(ns limit
  (:require limit.break))

;; I know, I know: single-segment namespaces are evil. So don't use
;; this out of dev-time. But the shorter name is nice.

(defmacro break [] `(limit.break/break))
