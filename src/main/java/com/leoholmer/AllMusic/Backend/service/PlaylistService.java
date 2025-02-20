package com.leoholmer.AllMusic.Backend.service;

import com.leoholmer.AllMusic.Backend.model.Playlist;
import com.leoholmer.AllMusic.Backend.model.Song;
import com.leoholmer.AllMusic.Backend.model.User;

import java.util.List;

public interface PlaylistService {
    /**
     * Retorna todas las playlists disponibles.
     *
     * @return Lista de playlists.
     */
    List<Playlist> getAllPlaylists();

    /**
     * Retorna una playlist específica por su ID.
     *
     * @param id Identificador único de la playlist.
     * @return La playlist encontrada, o null si no existe.
     */
    Playlist getPlaylistById(Long id);

    /**
     * Crea una nueva playlist.
     *
     * @param playlist La playlist a crear.
     */
    void createPlaylist(Playlist playlist);

    /**
     * Actualiza una playlist existente.
     *
     * @param playlist La playlist actualizada.
     */
    void updatePlaylist(Playlist playlist);

    /**
     * Elimina una playlist específica.
     *
     * @param playlist La playlist a eliminar.
     */
    void deletePlaylist(Playlist playlist);

    /**
     * Retorna todas las playlists creadas por un usuario específico.
     *
     * @param user El usuario propietario de las playlists.
     * @return Lista de playlists del usuario.
     */
    List<Playlist> getPlaylistsByUser(User user);

    /**
     * Retorna una canción específica por su ID.
     *
     * @param id Identificador único de la canción.
     * @return La canción encontrada, o null si no existe.
     */
    Song getSongById(Long id);
}