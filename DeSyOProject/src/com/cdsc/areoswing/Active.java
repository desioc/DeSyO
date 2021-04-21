package com.cdsc.areoswing;

/*
 * Areoswing - version 1.0 - EJE integration
 *
 * Copyright (C) Claudio De Sio Cesari
 *
 * Require JDK 1.8
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 *
 *
 * Info, Questions, Suggestions & Bugs Report to eje@claudiodesio.com
 *
 */
/**
 * This interface must be implemented by the GUI objects that are not containers
 * and that handle events.
 *
 * @author Claudio De Sio Cesari
 *
 */
public interface Active {
	/**
	 * This method is used to add listeners to the instance variable components.
	 */
	void registerListeners();

}
