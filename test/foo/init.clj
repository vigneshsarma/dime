;   Copyright (c) Shantanu Kumar. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file LICENSE at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.


(ns foo.init
  (:require
    [dime.core :as di]
    [dime.var  :as dv]))


(def graph (dv/ns-vars->graph ['foo.web
                               'foo.service
                               'foo.db]))


(defn viz-payload
  []
  {:graph-data  (di/attr-map graph :dep-ids)
   :node-labels (di/attr-map graph #(str (:node-id %) \newline (:impl-id %)))
   :node-shapes (di/attr-map graph #(when (:post-inj %) :rectangle))})
