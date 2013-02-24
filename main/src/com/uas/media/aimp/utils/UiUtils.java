/*
 * Copyright (c) 2013, Sorokin Alexander (uas.sorokin@gmail.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * 3. The names of the authors may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.uas.media.aimp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uas.media.aimp.R;

/**
 * User: uas.sorokin@gmail.com
 */
public class UiUtils {

    private UiUtils() {

    }

    public static void sDisplayHelp(final Context context, int title, int message) {
        sDisplayHelp(
                context,
                context.getResources().getString(title),
                context.getResources().getString(message)
        );
    }


    public static void sDisplayHelp(final Context context, String title, String message) {
		LayoutInflater inflater = LayoutInflater.from(context);

		LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.popup_content, null);

		TextView tv = (TextView) ll.findViewById(R.id.info_content);
		tv.setText(Html.fromHtml(message));
		tv.setMovementMethod(LinkMovementMethod.getInstance());

		AlertDialog alertDialog = new AlertDialog.Builder(context)
			.setTitle(title)
			.setView(ll)
			.setNeutralButton(
					context.getResources().getString(R.string.close),
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {}
					}
			)
			.create()
		;
		alertDialog.show();
	}

}