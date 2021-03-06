/*
 * Copyright (c) 2016 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License") ;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.dataservices.scdf.source.transform;

import org.apache.geode.pdx.JSONFormatter;
import org.apache.geode.pdx.PdxInstance;
//import org.apache.geode.json.JSONException;
//import org.apache.geode.json.JSONObject;

/**
 * @author David Turanski
 *
 */
public class JsonObjectTransformer {

	public PdxInstance toObject(String json) {
//		JSONObject jsonObject = null;
//		try {
//			jsonObject = new JSONObject(json);
//		}
//		catch (JSONException e) {
//			throw new MessageTransformationException(e.getMessage());
//		}
//		return JSONFormatter.fromJSON(jsonObject.toString());
        return JSONFormatter.fromJSON(json);
	}

	public String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof PdxInstance) {
			String json = JSONFormatter.toJSON((PdxInstance) obj);
			// de-pretty
			return json.replaceAll("\\r\\n\\s*", "").replaceAll("\\n\\s*", "")
					.replaceAll("\\s*:\\s*", ":").trim();
		}
		return obj.toString();
	}
}